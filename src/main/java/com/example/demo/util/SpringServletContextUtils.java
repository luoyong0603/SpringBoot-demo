package com.example.demo.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


public class SpringServletContextUtils {

    /**
     * 得到request对象
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (servletRequestAttributes != null) {
            request = servletRequestAttributes.getRequest();
        }
        return request;
    }

    /**
     * 得到当前response对象
     *
     * @return
     */
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        return response;
    }

    /**
     * 得到当前session信息
     *
     * @return
     */
    public static HttpSession getHttpSession() {
        return getRequest().getSession();
    }

    /**
     * 得到当前用户信息
     *
     * @return
     */
//    public static SysUser getUser() {
//        HttpSession session = getHttpSession();
//        SessionVo sessionVo = null;
//        SysUser user = null;
//        if (null != session.getAttribute(session.getId())) {
//            sessionVo = (SessionVo) session.getAttribute(session.getId());
//            user = sessionVo.getUser();
//        }
//        return user;
//    }

    /**
     * 得到当前变电站ids
     */
//    public static List<Integer> getSubs() {
//        HttpSession session = getHttpSession();
//        List<Integer> subList = null;
//        if (null != session.getAttribute(session.getId())) {
//            SessionVo sessionVo = (SessionVo) session.getAttribute(session.getId());
//            subList = sessionVo.getSubLists();
//        }
//        return subList;
//    }


    /**
     * 得到当前公司信息
     * @return
     */
//	public static Company getCompany() {
//		HttpSession session = getHttpSession();
//		SessionVo sessionVo=null;
//		Company company = null;
//		if(null != session.getAttribute(session.getId())) {
//			sessionVo = (SessionVo)session.getAttribute(session.getId());
//			company=sessionVo.getCompany();
//		}
//		return company;
//	}

    /**
     * 得到当前部门信息
     * @return
     */
//	public static Department getDepartment() {
//		HttpSession session = getHttpSession();
//		SessionVo sessionVo=null;
//		Department department = null;
//		if(null != session.getAttribute(session.getId())) {
//			sessionVo = (SessionVo)session.getAttribute(session.getId());
//			department=sessionVo.getDepartment();
//		}
//		return department;
//	}

    /**
     * 设置当前默认得机器人信息
     * @return
     */
//	public static boolean setRobotSet(RobotSet robotSet) {
//		try {
//			HttpSession session = getHttpSession();
//			SessionVo sessionVo=null;
//			if(null != session.getAttribute(session.getId())) {
//				sessionVo = (SessionVo)session.getAttribute(session.getId());
//			} else {
//				sessionVo = new SessionVo();
//			}
//			sessionVo.setRobotSet(robotSet);
//			session.setAttribute(session.getId(), sessionVo);
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//
//	}

    /**
     * 设置当前默认得场站信息
     * @return
     */
//	public static boolean setSubstation(Substation substation) {
//		try {
//			HttpSession session = getHttpSession();
//			SessionVo sessionVo=null;
//			if(null != session.getAttribute(session.getId())) {
//				sessionVo = (SessionVo)session.getAttribute(session.getId());
//			} else {
//				sessionVo = new SessionVo();
//			}
//			sessionVo.setSubstation(substation);
//			session.setAttribute(session.getId(), sessionVo);
//			return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//	}

    /**
     * 得到当前默认机器人信息
     * @return
     */
//	public static RobotSet getRobotSet() {
//		HttpSession session = getHttpSession();
//		SessionVo sessionVo=null;
//		RobotSet robotSet = null;
//		if(null != session.getAttribute(session.getId())) {
//			sessionVo = (SessionVo)session.getAttribute(session.getId());
//			robotSet = sessionVo.getRobotSet();
//		}
//		return robotSet;
//	}

    /**
     * 得到当前默认场站信息
     * @return
     */
//	public static Substation getSubstation() {
//		HttpSession session = getHttpSession();
//		SessionVo sessionVo=null;
//		Substation substation = null;
//		if(null != session.getAttribute(session.getId())) {
//			sessionVo = (SessionVo)session.getAttribute(session.getId());
//			substation=sessionVo.getSubstation();
//		}
//		return substation;
//	}

}
