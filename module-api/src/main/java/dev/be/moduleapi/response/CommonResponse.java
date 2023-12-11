package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.*;

@Getter
@Setter
@Builder
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> {
    private String returnCode;
    private String returnMessage;
    private T info;

    public CommonResponse(CodeEnum codeEnum) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

    // info 만 줄테니 너가 세팅을 알아서 해줘.. Info 값이 넘어온거라면 성공으로 간주
    public CommonResponse(T info) {
        setReturnCode(CodeEnum.SUCCESS.getCode());
        setReturnMessage(CodeEnum.SUCCESS.getMessage());
        setInfo(info);
    }

    // 둘 다 보낼 때
    public CommonResponse(CodeEnum codeEnum, T info) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
        setInfo(info);
    }
}
