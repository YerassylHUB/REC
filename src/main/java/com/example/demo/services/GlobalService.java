package com.example.demo.services;

import com.example.demo.dtos.GlobalResponseDTO;
import java.util.List;

public interface GlobalService {

    List<GlobalResponseDTO> getAllData() throws Exception;

}
