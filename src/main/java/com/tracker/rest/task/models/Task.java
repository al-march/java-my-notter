package com.tracker.rest.task.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    String name;
    String description;
}
