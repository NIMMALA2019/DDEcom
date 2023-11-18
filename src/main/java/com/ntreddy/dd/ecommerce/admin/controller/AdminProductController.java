//package com.ntreddy.dd.ecommerce.admin.controller;
//
//import static com.ntreddy.dd.ecommerce.constants.PathConstants.API_V1_PERFUMES;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ntreddy.dd.ecommerce.dto.HeaderResponse;
//import com.ntreddy.dd.ecommerce.dto.perfume.PerfumeResponse;
//import com.ntreddy.dd.ecommerce.mapper.PerfumeMapper;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(API_V1_PERFUMES)
//public class AdminProductController {
//	
//	@Autowired
//    private PerfumeMapper perfumeMapper;
////	@Autowired
////    private final GraphQLProvider graphQLProvider;
//
//    @GetMapping
//    public ResponseEntity<List<?>> getAllPerfumes(@PageableDefault(size = 15) Pageable pageable) {
//        HeaderResponse<PerfumeResponse> response = perfumeMapper.getAllPerfumes(pageable);
//        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
//    }
//
////    @GetMapping(PERFUME_ID)
////    public ResponseEntity<FullPerfumeResponse> getPerfumeById(@PathVariable Long perfumeId) {
////        return ResponseEntity.ok(perfumeMapper.getPerfumeById(perfumeId));
////    }
////
////    @PostMapping(IDS)
////    public ResponseEntity<List<PerfumeResponse>> getPerfumesByIds(@RequestBody List<Long> perfumesIds) {
////        return ResponseEntity.ok(perfumeMapper.getPerfumesByIds(perfumesIds));
////    }
////
////    @PostMapping(SEARCH)
////    public ResponseEntity<List<PerfumeResponse>> findPerfumesByFilterParams(@RequestBody PerfumeSearchRequest filter,
////                                                                            @PageableDefault(size = 15) Pageable pageable) {
////        HeaderResponse<PerfumeResponse> response = perfumeMapper.findPerfumesByFilterParams(filter, pageable);
////        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
////    }
////
////    @PostMapping(SEARCH_GENDER)
////    public ResponseEntity<List<PerfumeResponse>> findByPerfumeGender(@RequestBody PerfumeSearchRequest filter) {
////        return ResponseEntity.ok(perfumeMapper.findByPerfumeGender(filter.getPerfumeGender()));
////    }
////
////    @PostMapping(SEARCH_PERFUMER)
////    public ResponseEntity<List<PerfumeResponse>> findByPerfumer(@RequestBody PerfumeSearchRequest filter) {
////        return ResponseEntity.ok(perfumeMapper.findByPerfumer(filter.getPerfumer()));
////    }
////
////    @PostMapping(SEARCH_TEXT)
////    public ResponseEntity<List<PerfumeResponse>> findByInputText(@RequestBody SearchTypeRequest searchType,
////                                                                 @PageableDefault(size = 15) Pageable pageable) {
////        HeaderResponse<PerfumeResponse> response = perfumeMapper.findByInputText(searchType.getSearchType(), searchType.getText(), pageable);
////        return ResponseEntity.ok().headers(response.getHeaders()).body(response.getItems());
////    }
////
////    @PostMapping(GRAPHQL_IDS)
////    public ResponseEntity<ExecutionResult> getPerfumesByIdsQuery(@RequestBody GraphQLRequest request) {
////        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
////    }
////
////    @PostMapping(GRAPHQL_PERFUMES)
////    public ResponseEntity<ExecutionResult> getAllPerfumesByQuery(@RequestBody GraphQLRequest request) {
////        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
////    }
////
////    @PostMapping(GRAPHQL_PERFUME)
////    public ResponseEntity<ExecutionResult> getPerfumeByQuery(@RequestBody GraphQLRequest request) {
////        return ResponseEntity.ok(graphQLProvider.getGraphQL().execute(request.getQuery()));
////    }
//
//}
