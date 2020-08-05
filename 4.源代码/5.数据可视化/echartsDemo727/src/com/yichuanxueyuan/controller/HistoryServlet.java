package com.yichuanxueyuan.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yichunxueyuan.entity.ProvinceSales;



import com.yichunxueyuan.manager.SalesManager;

import net.sf.json.JSONObject;

public class HistoryServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("textml;charset=utf-8");  
		  
		SalesManager us =new  SalesManager();
		  
		  List lists = us.queryAllGMVs();
		  
		  
		  Gson gson = new Gson();

			//
		  String gmvs = gson.toJson(lists);
		  
		  /*for(int i = 0;i<lists.size();i++){
			  
			  ProvinceSales ps = (ProvinceSales)lists.get(i);
			  
			  json.put("ps"+(i+1), ps);
			  
		  }*/
		  
		  
		  
		  /*
		  ProvinceSales ps1 = new ProvinceSales();
		  ProvinceSales ps2 = new ProvinceSales();
		  ProvinceSales ps3 = new ProvinceSales();
		  ProvinceSales ps4 = new ProvinceSales();
		  
		  ps1.setProvinceName("shandong");
		  ps1.setAmount(1234);
		  
		  ps2.setProvinceName("jiangxi");
		  ps2.setAmount(5345);
		  
		  
		  ps3.setProvinceName("beijing");
		  ps3.setAmount(2000);
		  
		  ps4.setProvinceName("shanghai");
		  ps4.setAmount(4345);
		  
		  
		  json.put("ps1", ps1);
		  
		  */
		  
		  
		 // json.put("provinceName2", "Beiijng");
		

		  
		  System.out.println(gmvs);
		  
		  
		  response.getWriter().print(gmvs);
	
	}

}
