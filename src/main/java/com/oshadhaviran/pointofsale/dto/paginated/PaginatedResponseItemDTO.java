package com.oshadhaviran.pointofsale.dto.paginated;

import com.oshadhaviran.pointofsale.dto.response.ItemGetResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaginatedResponseItemDTO {
    private  List<ItemGetResponseDTO> List;
    private long dataCount;






}
