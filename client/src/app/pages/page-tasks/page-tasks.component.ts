import { Component, OnInit } from '@angular/core';
import { TaskService } from '@app/core/services';

@Component({
  selector: 'app-page-tasks',
  templateUrl: './page-tasks.component.html',
  styleUrls: ['./page-tasks.component.scss']
})
export class PageTasksComponent implements OnInit {

  tasks$ = this.taskService.getAll();

  constructor(
    private taskService: TaskService
  ) { }

  ngOnInit(): void {
  }

}
