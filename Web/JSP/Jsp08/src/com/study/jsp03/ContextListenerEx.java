package com.study.jsp03;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 컨텍스트리스너 : 웹 어플리케이션이 시작되거나 중지될 떄, 그 알림을 받음

@WebListener
public class ContextListenerEx implements ServletContextListener {

    public ContextListenerEx() {
        
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed");
		// 이 메소드는 어플이 중지될때 호출 
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized");
		// 이 메소드는 어플이 시작될때 호출 
	}

}
