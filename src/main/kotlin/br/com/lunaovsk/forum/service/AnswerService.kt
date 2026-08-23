package br.com.lunaovsk.forum.service

import br.com.lunaovsk.forum.dto.request.AnswerRequest
import br.com.lunaovsk.forum.dto.view.AnswerView
import br.com.lunaovsk.forum.infra.repository.AnswerRepository
import br.com.lunaovsk.forum.mapper.request.RequestMapper
import br.com.lunaovsk.forum.mapper.view.Mapper
import br.com.lunaovsk.forum.model.answer.Answer
import br.com.lunaovsk.forum.validation.Validator
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AnswerService (
    private val answerRepository: AnswerRepository,
    private val requestMapper: RequestMapper<AnswerRequest, Answer>,
    private val viewMapper: Mapper<Answer, AnswerView>,
    private val validator: Validator<AnswerRequest>
) {
    fun getAllAnswers(): List<AnswerView> {
        val list = answerRepository.findAll();
        return list.map(viewMapper::map);
    }

    @Transactional
    fun create(answerDTO: AnswerRequest): AnswerView {
        validator.validate(answerDTO);
        val answer = requestMapper.map(answerDTO);
        val createdAnswer = answerRepository.save(answer);
        return viewMapper.map(createdAnswer);
    }
}
