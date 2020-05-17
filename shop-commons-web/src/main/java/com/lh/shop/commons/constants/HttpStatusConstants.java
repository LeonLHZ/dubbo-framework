package com.lh.shop.commons.constants;

/**
 * @author Neo
 * @date 2020/5/9 22:23
 */
public enum HttpStatusConstants
{
    BAD_GETWAT(502, "从上游服务器接收到无效的响应");
    private int status;
    private String content;

    private HttpStatusConstants(int status, String content)
    {
        this.status = status;
        this.content = content;

    }

    public int getStatus()
    {
        return status;
    }

    public String getContent()
    {
        return content;
    }
}
