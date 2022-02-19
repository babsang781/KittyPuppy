package com.kittypuppy.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kittypuppy.model.FeedDAO;
import com.kittypuppy.model.FeedDTO;
import com.kittypuppy.model.MemberDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FeedCreateCon implements iCommand{

	FeedDTO feed = null;
	FeedDAO dao = new FeedDAO();
	MemberDTO member = null;

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 저장 경로 지정
		String saveDir = "C:/Users/smhrd/git/KittyPuppy/GitTest/src/main/webapp/assets/img";
		
		// 파일 저장
		MultipartRequest multi = new MultipartRequest(request, saveDir, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		// DB 저장 을 위한 값 받아오기
		String content = multi.getParameter("content");
		String tag = multi.getParameter("tag");
		int openRange = Integer.parseInt(multi.getParameter("openRange"));
		
		String picAddress1 = multi.getFilesystemName("picAddress1");
		String picAddress2 = multi.getFilesystemName("picAddress2");
		String picAddress3 = multi.getFilesystemName("picAddress3");
		String picAddress4 = multi.getFilesystemName("picAddress4");
		String picAddress5 = multi.getFilesystemName("picAddress5");
		ArrayList<String> paList = new ArrayList<String>();
		
		if (picAddress1 != null) {
			paList.add(".assets/img/"+picAddress1);
		}
		if (picAddress2 != null) {
			paList.add(".assets/img/"+picAddress2);
		}
		if (picAddress3 != null) {
			paList.add(".assets/img/"+picAddress3);
		}
		if (picAddress4 != null) {
			paList.add(".assets/img/"+picAddress4);
		}
		if (picAddress5 != null) {
			paList.add(".assets/img/"+picAddress5);
		}
		
		String picAddress = String.join(",", paList);
		
		System.out.println(content);
		System.out.println(tag);
		System.out.println(openRange);
		System.out.println(picAddress);
	}

}
