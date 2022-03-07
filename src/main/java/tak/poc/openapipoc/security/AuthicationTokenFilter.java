package tak.poc.openapipoc.security;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import tak.poc.openapipoc.ApplicationConstant;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class AuthicationTokenFilter  extends AbstractPreAuthenticatedProcessingFilter {
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return "UnknownSMUserId";
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        String gskToken = request.getHeader(ApplicationConstant.GSK);
        return Objects.isNull(gskToken) ? ApplicationConstant.GSK_NOT_FOUND : gskToken;
    }
}
