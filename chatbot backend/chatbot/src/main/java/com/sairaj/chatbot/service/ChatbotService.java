package com.sairaj.chatbot.service;

import com.sairaj.chatbot.response.ApiResponse;

public interface ChatbotService {

    ApiResponse getCoinDetails(String prompt) throws Exception;

    String simpleChat(String prompt);
}
