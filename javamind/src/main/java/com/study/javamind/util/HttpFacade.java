package com.study.javamind.util;
import com.study.javamind.vo.HttpReqParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface HttpFacade {

    /**
     * 有效参数如下
     * 
//     * @param address 请求地址
//     * @param reqCharSet 请求内容字符集
//     * @param repCharSet 返回内容字符集
     * @return http请求回来的数据必须是xml或者json
     */
    @RequestMapping(value = "service/http/get", method = RequestMethod.POST)
    BaseResult<String> get(@RequestBody HttpReqParam httpReqParam);

    /**
     * 发送http post请求
     * 
     * 有效参数如下
     * 
//     * @param address 请求地址
//     * @param reqCharSet 请求内容字符集
//     * @param repCharSet 返回内容字符集
     * @return
     */
    @RequestMapping(value = "service/http/post", method = RequestMethod.POST)
    BaseResult<String> post(@RequestBody HttpReqParam httpReqParam);

    /**
     * 通过post请求获取数据
     * 
     * @author liuzhongqi
     * @date: 2016年10月10日 上午11:20:02
     * @version 1.0
     *
     *          有效参数如下
//     * @param address 访问地址
//     * @param body post的消息体
//     * @param reqCharSet post消息体的编码 可null 默认utf-8
//     * @param respCharSet 返回加过的编码 可null 默认utf-8
//     * @param contentType http content-type 可null 默认text/plain
     * @return
     */
    @RequestMapping(value = "service/http/postbdoy", method = RequestMethod.POST)
    BaseResult<String> postBody(@RequestBody HttpReqParam httpReqParam);

    /**
     * 通过post请求获取数据bytes,针对获取小程序二维码,返回bytes
     *
     * @author mocaijin
     * @date: 2018年7月3日 上午11:20:02
     * @version 1.0
     *
     *          有效参数如下
//     * @param address 访问地址
//     * @param body post的消息体
//     * @param reqCharSet post消息体的编码 可null 默认utf-8
//     * @param respCharSet 返回加过的编码 可null 默认utf-8
//     * @param contentType http content-type 可null 默认text/plain
     * @return
     */
    @RequestMapping(value = "service/http/getBytesPostBody", method = RequestMethod.POST)
    BaseResult<byte[]> getBytesPostBody(@RequestBody HttpReqParam httpReqParam);

    /**
     * 
     * 调用远程webservice（访问医院数据）. 默认编码格式UTF-8，XML格式<br/>
     * 
     * @author liujingcheng
     * @date: 2016年11月10日 下午2:56:30
     * @version 1.0
     *
     *          有效参数如下
//     * @param address 访问地址
//     * @param body 访问参数
//     * @param soapAction webservice的SOAPAction
     * @return
     */
    @RequestMapping(value = "service/http/postsoapaction", method = RequestMethod.POST)
    BaseResult<String> postSoapAction(@RequestBody HttpReqParam httpReqParam);

    /**
     * post请求. <br/>
     * 
     * @author liujingcheng
     * @date: 2016年11月10日 下午2:53:40
     * @version 1.0
     *
     *          有效参数如下
//     * @param String address 访问url
//     * @param byte[] body body参数
//     * @param String reqCharSet 请求编码格式
//     * @param String respCharSet 响应编码格式
//     * @param Header[] headers 头信息
     * @return
     */
    @RequestMapping(value = "service/http/postwithhead", method = RequestMethod.POST)
    BaseResult<String> postWithHead(@RequestBody HttpReqParam httpReqParam);
}
