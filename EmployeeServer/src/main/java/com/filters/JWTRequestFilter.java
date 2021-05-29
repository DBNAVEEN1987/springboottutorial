package com.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.emp.service.CustomUserDetailService;
import com.util.JwtTokenUtil;

@Component
public class JWTRequestFilter extends OncePerRequestFilter {

	@Autowired
	private CustomUserDetailService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filter)
			throws ServletException, IOException {
		final String authorizationToken = request.getHeader("Authorization");
		if (StringUtils.isNotEmpty(authorizationToken)
				&& StringUtils.startsWith(authorizationToken, "Bearer ")) {
			String jwtToken = StringUtils.substring(authorizationToken, 7);
			String userName = jwtUtil.getUsernameFromToken(jwtToken);
			if (userName != null
					&& SecurityContextHolder.getContext().getAuthentication() == null) {
				UserDetails userDetails = userDetailsService
						.loadUserByUsername(userName);
				if (userDetails != null
						&& jwtUtil.validateToken(jwtToken, userDetails)) {

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource()
									.buildDetails(request));
					// After setting the Authentication in the context, we
					// specify
					// that the current user is authenticated. So it passes the
					// Spring Security Configurations successfully.
					SecurityContextHolder.getContext().setAuthentication(
							usernamePasswordAuthenticationToken);
					HttpSession session = request.getSession();
					session.setAttribute("USERNAME", userName);
				}
			}
		}
		filter.doFilter(request, response);
	}

}
