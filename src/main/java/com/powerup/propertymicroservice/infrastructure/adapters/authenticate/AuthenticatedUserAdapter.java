package com.powerup.propertymicroservice.infrastructure.adapters.authenticate;

import com.powerup.propertymicroservice.domain.ports.out.AuthenticatedUserPort;
import com.powerup.propertymicroservice.infrastructure.security.jwt.DecodedJwtHolder;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatedUserAdapter implements AuthenticatedUserPort {
    
    @Override
    public Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof DecodedJwtHolder decodedJwtHolder) {
            return decodedJwtHolder.getUserId();
        }
        throw new RuntimeException("Could not obtain the authenticated user's ID.");
    }

    @Override
    public List<String> getCurrentUserRoles() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof DecodedJwtHolder decodedJwtHolder) {
            return decodedJwtHolder.getAuthorities()
                    .stream()
                    .map(grantedAuthority -> grantedAuthority.getAuthority())
                    .toList();
        }
        throw new RuntimeException("Could not obtain the authenticated user's roles.");
    }
}
