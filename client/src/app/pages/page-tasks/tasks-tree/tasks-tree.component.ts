import { Component, Input, OnInit } from '@angular/core';
import { TaskDto } from '@app/core/dto';

@Component({
  selector: 'app-tasks-tree',
  templateUrl: './tasks-tree.component.html',
  styleUrls: ['./tasks-tree.component.scss']
})
export class TasksTreeComponent implements OnInit {

  @Input()
  task?: TaskDto;

  constructor() { }

  ngOnInit(): void {
  }

}
