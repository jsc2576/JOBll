package com.jobll.web.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jobll.web.CommonUtil;
import com.jobll.web.usrinfo.UsrInfo;

@Component
public class SessionUtil {
	
	@Autowired
	private CommonUtil commonUtil;

	/**
	 * attributeName이름으로 object를 session attribute에 담는다.
	 * @param attributeName
	 * @param object
	 */
	/*public void setNewSession(String attributeName, Object object) {
		HttpServletRequest request = this.commonUtil.getCurrentRequest();
		
		HttpSession session = getNewSession(request);
		session.setAttribute(attributeName, object);
	}*/
	public void setNewSession(String attributeName, UsrInfo object) {
		HttpServletRequest request = this.commonUtil.getCurrentRequest();
		
		HttpSession session = getNewSession(request);
		
		session.setAttribute(attributeName, object);
	}
	/**
	 * request로부터 HttpSession객체 반환
	 * @param request
	 * @return
	 */
	public HttpSession getNewSession(HttpServletRequest request) {
		return request.getSession(true);
	}
	
	/**
	 * SessionBean객체 반환
	 * @return
	 * @throws RuntimeException
	 */
	public UsrInfo getSessionBean() throws RuntimeException {
		HttpServletRequest request = this.commonUtil.getCurrentRequest();
		
		HttpSession session = request.getSession(false);
		return (UsrInfo)session.getAttribute("SessionBean");
		
		//if (session != null) return (UsrInfo) session.getAttribute(CommonConstant.USER_SESSION_NAME);
		//else return null;
	}
	
	/**
	 * HttpSession객체에서 세션 제거
	 */
	public void invalidateSession() {
		HttpServletRequest request = this.commonUtil.getCurrentRequest();
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute(CommonConstant.USER_SESSION_NAME);
			session.invalidate();
		}
	}
}
