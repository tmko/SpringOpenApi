package tak.poc.openapipoc.security;

import org.springframework.security.access.intercept.RunAsUserToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import tak.poc.openapipoc.ApplicationConstant;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class GASAuthenticationManager implements AuthenticationManager {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        List<String> auth = authentication.getAuthorities().stream().map(Objects::toString).collect(toList());
        String cred = authentication.getCredentials().toString();
        String name = authentication.getName();
        String detail = authentication.getDetails().toString();
        String prp = authentication.getPrincipal().toString();


        if ( cred.equals(ApplicationConstant.GSK_NOT_FOUND) ) {
            throw new AuthenticationCredentialsNotFoundException("GSK token not found");
        } else if ( cred.contains("BAD") ) {
            throw new BadCredentialsException("GSK token isvaild");
        } else if ( cred.contains("OUT") ) {
            throw new AuthenticationServiceException("GAS team is out");
        }

        return new RunAsUserToken("ServiceManagerUserId", "SmUserId", cred, null, null);
    }
}
