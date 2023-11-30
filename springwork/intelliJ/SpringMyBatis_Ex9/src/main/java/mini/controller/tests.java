package mini.controller;

import org.springframework.transaction.annotation.Transactional;

public class tests {

    /**
     * 소셜 로그인
     * <p>
     * OAuth 인가 코드를 받아서 토큰을 발급받고, 토큰을 이용해 계정 정보를 가져온다.
     */
//    @Override
//    @Transactional
//    public ResponseEntity<SignInResponseDto> signIn(
//            final OAuthRequestDto oAuthRequestDto
//    ) {
//        String authCode = oAuthRequestDto.getAuthCode();
//        OAuthTokenResponseDto tokenResponse = getOAuthToken(authCode);
//
//        OAuthAccountInfoDto accountInfo = getAccountInfo(tokenResponse.getAccessToken());
//        String email = accountInfo.getEmail();
//        String userName = accountInfo.getName();
//
//        checkIfAccountLocallyRegistered(accountInfo);
//
//        saveTokenToRedis(tokenResponse, email);
//        JwtResponseDto jwtResponseDto = issueJwtToken(email);
//
//        return createSignInResponse(jwtResponseDto, userName);
//    }
}
