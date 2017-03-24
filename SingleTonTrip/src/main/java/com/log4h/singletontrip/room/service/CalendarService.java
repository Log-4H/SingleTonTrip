package com.log4h.singletontrip.room.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log4h.singletontrip.room.domain.CalendarVo;
import com.log4h.singletontrip.room.domain.RoomReserveVo;
import com.log4h.singletontrip.room.repository.RoomDao;

@Service
public class CalendarService {

	@Autowired
	private RoomDao roomDao;
	
	public Map<String, Object> getOneDayList(int roomNo, int ddayYear, int ddayMonth, String ddayOption) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// dday : ?년 + ?월 + 1일
		Calendar dday = Calendar.getInstance();
		dday.set(Calendar.DATE, 1);
		if (ddayOption.equals("prev")) {
			dday.set(ddayYear, ddayMonth, 1);
			dday.add(Calendar.MONTH, -1);
		} else if (ddayOption.equals("next")) {
			dday.set(ddayYear, ddayMonth, 1);
			dday.add(Calendar.MONTH, 1);
		}
		// 1일의 요일
		int firstWeek = dday.get(Calendar.DAY_OF_WEEK);

		List<CalendarVo> calendarList = new ArrayList<CalendarVo>();

		// 마지막 날짜
		int endDay = dday.getActualMaximum(Calendar.DATE); // 달의 마지막 날짜를 구하는 메서드

		// 7의배수가 되기위해 필요한 List size(날짜가 들어가야할 <td>의 갯수)
		int listSize = (firstWeek - 1) + endDay;
		if (listSize / 7 != 0) {
			listSize = listSize + (7 - (listSize % 7));
		}

		// 이전달 마지막 일
		Calendar preMonth = Calendar.getInstance();
		preMonth.set(Calendar.MONTH, dday.get(Calendar.MONTH) - 1);
		int preLastDay = preMonth.getActualMaximum(Calendar.DATE);
		int beginSpace = preLastDay - (firstWeek - 2);
		int endSpace = 1;
		for (int i = 0; i < listSize; i++) {
			CalendarVo calendar;
			if (i < (firstWeek - 1)) {
				calendar = new CalendarVo();
				calendar.setDay(beginSpace);
				beginSpace++;
			} else if (i < ((firstWeek - 1) + endDay)) {
				calendar = new CalendarVo();
				calendar.setYear(dday.get(Calendar.YEAR));
				calendar.setMonth(dday.get(Calendar.MONTH) + 1);
				calendar.setDay((i + 1) - (firstWeek - 1));
				int month = calendar.getMonth();
				int day = calendar.getDay();
				String monthText = Integer.toString(month);
				String dayText = Integer.toString(day);
				String zero = "0";
				if(month < 10){
					 monthText = zero + monthText;
				}
				if(day < 10){
					 dayText = zero + dayText;
				}
				String date = calendar.getYear()+"-"+monthText+"-"+dayText;
				calendar.setDate(date);
				Map<String, Object> paramMap = new HashMap<String,Object>();
				paramMap.put("roomNo", roomNo);
				paramMap.put("date", date);
				RoomReserveVo roomReserveVo = roomDao.roomReserveCheck(paramMap);
				calendar.setReserveVo(roomReserveVo);
			} else {
				calendar = new CalendarVo();
				calendar.setDay(endSpace);
				endSpace++;
			}
			calendarList.add(calendar);
		}
		returnMap.put("calendarList", calendarList);
		returnMap.put("ddayYear", dday.get(Calendar.YEAR));
		returnMap.put("ddayMonth", dday.get(Calendar.MONTH));

		return returnMap;
	}
}
