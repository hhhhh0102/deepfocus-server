//package io.poten13.deepfocus.domain.task.controller
//
//import io.poten13.deepfocus.global.dto.ApiResponse
//import io.swagger.v3.oas.annotations.Operation
//import org.springframework.web.bind.annotation.PostMapping
//import org.springframework.web.bind.annotation.RequestBody
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//
//@RestController
//@RequestMapping("/api/v1/tasks")
//class TaskController(
//    private val taskService: TaskService
//) {
//
//    @Operation(summary = "태스크 생성")
//    @PostMapping
//    fun createTask(@RequestBody request: CreateTaskRequest): ApiResponse<TaskResponse> {
//        taskService.save(request)
//    }
//}