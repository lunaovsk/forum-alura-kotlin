package br.com.lunaovsk.forum.controller.answer

import br.com.lunaovsk.forum.dto.request.AnswerRequest
import br.com.lunaovsk.forum.dto.view.AnswerView
import br.com.lunaovsk.forum.service.AnswerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/answers")
class AnswerController (
    private val service: AnswerService
) {
    @GetMapping
    fun getAllAnswers(): ResponseEntity<List<AnswerView>> {
        val list = service.getAllAnswers();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    fun createAnswer(@RequestBody answer: AnswerRequest): ResponseEntity<AnswerView> {
        val answerCreated = service.create(answer);
        return ResponseEntity.status(HttpStatus.CREATED).body(answerCreated);
    }
}
