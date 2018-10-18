package com.study.spring.gm;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GuestMessageController {
	
	@RequestMapping(value = "/list.xml")
	@ResponseBody
	public GuestMessageXMLList listXml() {
		return getMessageXmlList();
	}
	
	private GuestMessageXMLList getMessageXmlList() {
		List<GuestMessage> messages = Arrays.asList(
				new GuestMessage (1,"문정혁", new Date()),
				new GuestMessage (2,"이민우", new Date())
				);
		return new GuestMessageXMLList(messages);
	}
	
	@RequestMapping(value = "/list.json")
	@ResponseBody
//	public GuestMessageXMLList listJson() {
//		return getMessageXmlList();
//	}
//
//	private GuestMessageJSONList getMessageJsonList() {
//		List<GuestMessage> messages = Arrays.asList(
//				new GuestMessage (1,"김동완", new Date()),
//				new GuestMessage (2,"신혜성", new Date())
//				);
//		return new GuestMessageJSONList(messages);
//	}
	
	public List<GuestMessage>listJson() {
		List<GuestMessage> messages = Arrays.asList(
				new GuestMessage (1,"김동완", new Date()),
				new GuestMessage (2,"신혜성", new Date())
				);
		return messages;
	}
	
	
}
