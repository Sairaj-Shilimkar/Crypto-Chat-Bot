package com.sairaj.chatbot.Controller;

import com.sairaj.chatbot.DTO.PromptBody;
import com.sairaj.chatbot.response.ApiResponse;
import com.sairaj.chatbot.service.ChatBotServiceImpl;
import com.sairaj.chatbot.service.ChatbotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai/chat")
@CrossOrigin(origins = "http://localhost:3000")
public class ChatbotController {

    private final ChatbotService chatbotService;

    public ChatbotController(ChatbotService chatbotService) {
        this.chatbotService = chatbotService;
    }


    @PostMapping
    public ResponseEntity<ApiResponse> getCoinDetails(@RequestBody PromptBody prompt) throws Exception {


        ApiResponse response = chatbotService.getCoinDetails(prompt.getPrompt());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/simple")
    public ResponseEntity<String> simpleChatHandler(@RequestBody PromptBody prompt) throws Exception {
        String response = chatbotService.simpleChat(prompt.getPrompt());

//        ApiResponse response = new ApiResponse();
//        response.setMessage(prompt.getPrompt());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}