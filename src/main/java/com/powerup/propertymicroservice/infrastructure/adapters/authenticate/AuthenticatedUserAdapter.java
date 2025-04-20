package com.powerup.propertymicroservice.infrastructure.adapters.authenticate;

import com.powerup.propertymicroservice.domain.ports.out.AuthenticatedUserPort;
import com.powerup.propertymicroservice.infrastructure.security.jwt.DecodedJwtHolder;
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
        throw new RuntimeException("No se pudo obtener el ID del usuario autenticado.");
    }
}
