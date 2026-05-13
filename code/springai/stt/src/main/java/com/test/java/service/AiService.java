package com.test.java.service;

import org.springframework.ai.audio.transcription.AudioTranscriptionPrompt;
import org.springframework.ai.audio.transcription.AudioTranscriptionResponse;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionOptions;
import org.springframework.ai.openai.api.OpenAiAudioApi;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AiService {
	
	private final OpenAiAudioTranscriptionModel audioModel;

	public String transcribe(MultipartFile attach) {
		
		// .temperature(0F) <- 온도 0, 제일 정확하게 알아들으려고 노력
		// 온도 1이면 불명확한 음성이 들리면 LLM 마음대로 창조해냄
		try {
			OpenAiAudioTranscriptionOptions options = OpenAiAudioTranscriptionOptions.builder().responseFormat(OpenAiAudioApi.TranscriptResponseFormat.TEXT).language("ko").temperature(0F).build();
			
			// 프롬프트 생성
			AudioTranscriptionPrompt prompt = new AudioTranscriptionPrompt(attach.getResource(), options);
			// AI 모델 호출
			AudioTranscriptionResponse resp = audioModel.call(prompt);
			// 결과값 반환
			return resp.getResult().getOutput();
			
		} catch (Exception e) {
			System.out.println("AiService.transcribe");
			e.printStackTrace();
		}
		
		return null;
	}

}