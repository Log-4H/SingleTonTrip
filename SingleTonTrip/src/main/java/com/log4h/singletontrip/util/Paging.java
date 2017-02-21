package com.log4h.singletontrip.util;

import java.util.HashMap;
import java.util.Map;

public class Paging {

	public Map<String, Object> pagingMethod(int currentPage, int totalCount){
		Map<String, Object> map = new HashMap<String, Object>();
		int pagePerRow = 5;
        int pageSize = 3;
        int beginRow = (currentPage-1)*pagePerRow;
        int startPage =((currentPage-1)/pageSize)*pageSize+1;
        
        int endPage = startPage + pageSize -1;
        
        int lastPage = totalCount/pagePerRow;
        if(totalCount%pagePerRow!=0){
            lastPage++;
        }
        if(endPage > lastPage){
            endPage = lastPage;
        }
        
        map.put("beginRow", beginRow);
        map.put("pagePerRow", pagePerRow);
        map.put("startPage", startPage);
        map.put("pageSize", pageSize);
        map.put("endPage", endPage);
        map.put("lastPage", lastPage);
	
		return map;
	}
}
