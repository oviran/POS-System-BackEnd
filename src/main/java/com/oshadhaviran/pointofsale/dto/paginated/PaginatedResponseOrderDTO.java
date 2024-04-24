package com.oshadhaviran.pointofsale.dto.paginated;

import com.oshadhaviran.pointofsale.dto.response.ItemGetResponseDTO;
import com.oshadhaviran.pointofsale.dto.response.OrderGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PaginatedResponseOrderDTO {

    private  List<OrderGetResponseDTO> List;
    private long dataCount;




}
