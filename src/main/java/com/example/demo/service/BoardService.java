package com.example.demo.service;

import com.example.demo.dto.BoardSaveRequestDto;
import com.example.demo.dto.BoardSaveResponseDto;
import com.example.demo.dto.BoardSimpleResponseDto;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardSaveResponseDto saveBoard(BoardSaveRequestDto boardSaveRequestDto) {
        Board newBoard = new Board(
                boardSaveRequestDto.getTitle(),
                boardSaveRequestDto.getContents()
        );

        Board SavedBoard = boardRepository.save(newBoard);

        return new BoardSaveResponseDto(
                SavedBoard.getId(),
                SavedBoard.getTitle(),
                SavedBoard.getContents()
        );
    }


    public List<BoardSimpleResponseDto> getBoards() {
        List<Board> boardList = boardRepository.findAll();

        List<BoardSimpleResponseDto> dtoList = new ArrayList<>();

        for (Board board : boardList) {
            BoardSimpleResponseDto dto = new BoardSimpleResponseDto(board)
        }
    }
}
