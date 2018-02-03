package com.example.git_practice;



        import org.slf4j.MDC;

        import javax.servlet.*;
        import java.io.IOException;

/**
 * ログ出力用の診断コンテキストを設定するFilterクラス.
 */
public class LogSettingFilter implements Filter {

    String CLIENT = "client";
    String USER_ID = "userId";
    String SESSION_ID = "sessionId";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 診断コンテキストを設定します.
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            MDC.put(CLIENT, servletRequest.getRemoteAddr());
            MDC.put(USER_ID, "user name test");
            MDC.put(SESSION_ID, "session id test");
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            MDC.remove(CLIENT);
            MDC.remove(USER_ID);
            MDC.remove(SESSION_ID);
        }
    }

    @Override
    public void destroy() {

    }
}
