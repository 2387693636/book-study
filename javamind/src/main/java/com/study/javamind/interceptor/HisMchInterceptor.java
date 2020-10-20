package com.study.javamind.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.study.javamind.interceptor.annotation.CheckConfigNum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HisMchInterceptor implements HandlerInterceptor
{

    private static final Logger logger = LoggerFactory.getLogger(HisMchInterceptor.class);

    public static final List<String> NOAUTHURL = new ArrayList<>();

    public static final AntPathMatcher MATCHER = new AntPathMatcher();

    static {
        NOAUTHURL.add("/api/hismch/user/getCode");
        NOAUTHURL.add("/api/hismch/user/sendSmsVerificationCode");
        NOAUTHURL.add("/api/hismch/login");
        NOAUTHURL.add("/api/hismch/logout");
        NOAUTHURL.add("/api/hismch/auth/quotationPage");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 解决乱码
        boolean flag = false;
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        // Swragger请求
//        if (SwaggerUtils.isSwaggerPath(request.getRequestURI())) {
//            return true;
//        }
//        if (isNoAuthPath(request.getRequestURI())){
//            return true;
//        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        CheckConfigNum checkConfigNum = handlerMethod.getMethod().getAnnotation(CheckConfigNum.class);
        Class<?>[] parameterTypes = handlerMethod.getMethod().getParameterTypes();
        Type[] genericParameterTypes = handlerMethod.getMethod().getGenericParameterTypes();

        System.out.println(parameterTypes+"");
        if (Objects.nonNull(checkConfigNum)){
            System.out.println("sdad");
        }
//        UserPrincipal userPrincipal = UserPrincipal.authenticatedUser();
//        //校验用户是否有访问权限
//        //flag = checkAuthFacade.checkHisRequest(userPrincipal.getHisId(),request.getRequestURI()).checkAndGetData();
//        flag = true;
//        if (!flag){
//            logger.error("您没有访问权限");
//            JsonRespTool.writeJson(response, "{\"code\":403,\"msg\":\"您没有访问权限\"}");
//            return false;
//        }
//        if (handler instanceof HandlerMethod){
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            FunctionIsSupport functionIsSupport = handlerMethod.getMethod().getAnnotation(FunctionIsSupport.class);
//            if (Objects.nonNull(functionIsSupport)){
//                ValiHisConfigParam valiHisConfigParam = new ValiHisConfigParam();
//                valiHisConfigParam.setHisId(userPrincipal.getHisId());
//                valiHisConfigParam.setCodes(functionIsSupport.bizCode());
//                flag = checkAuthFacade.checkFunctionIsSupport(valiHisConfigParam).checkAndGetData();
//                if (!flag){
//                    JSONObject jo = new JSONObject();
//                    jo.put("code", "-1");
//                    jo.put("msg", functionIsSupport.errorMsg());
//                    JsonRespTool.writeJson(response, jo.toJSONString());
//                }
//            }
//            CheckConfigNum checkConfigNum = handlerMethod.getMethod().getAnnotation(com.gzhc365.op.web.interceptor.annotation.CheckConfigNum.class);
//            if (Objects.nonNull(checkConfigNum)){
//                CheckConfigNumParam verifyBizParam = new CheckConfigNumParam();
//                verifyBizParam.setHisId(userPrincipal.getHisId());
//                Integer useNum = 1;
//                 if (StringUtils.isNotBlank(request.getParameter(checkConfigNum.requestKey()))){
//                    useNum = Integer.parseInt(request.getParameter(checkConfigNum.requestKey()));
//                }
//                verifyBizParam.setUseNum(useNum);
//                verifyBizParam.setBizCode(checkConfigNum.code());
//                flag = checkAuthFacade.checkConfigNum(verifyBizParam).checkAndGetData();
//                if (!flag){
//                    JSONObject jo = new JSONObject();
//                    jo.put("code", "-1");
//                    jo.put("msg", checkConfigNum.errorMsg());
//                    JsonRespTool.writeJson(response, jo.toJSONString());
//                }
//            }
//            CheckConfigDate checkConfigDate = handlerMethod.getMethod().getAnnotation(CheckConfigDate.class);
//            if (Objects.nonNull(checkConfigDate)){
//                CheckConfigDateParam checkConfigDateParam = new CheckConfigDateParam();
//                checkConfigDateParam.setHisId(userPrincipal.getHisId());
//                checkConfigDateParam.setBizCode(checkConfigDate.code());
//                checkConfigDateParam.setStartDate(request.getParameter(checkConfigDate.requestKeys()[0]));
//                checkConfigDateParam.setEndDate(request.getParameter(checkConfigDate.requestKeys()[1]));
//                flag = checkAuthFacade.checkConfigDate(checkConfigDateParam).checkAndGetData();
//                if (!flag){
//                    JSONObject jo = new JSONObject();
//                    jo.put("code", "-1");
//                    jo.put("msg", checkConfigDate.errorMsg());
//                    JsonRespTool.writeJson(response, jo.toJSONString());
//                }
//            }
//        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public static  boolean isNoAuthPath(String path){
        return  NOAUTHURL.stream().filter(ele -> MATCHER.match(ele,path)).findFirst().isPresent();
    }
}
