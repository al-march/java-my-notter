import { Component, Input } from '@angular/core';
import { TaskDto } from '@app/core/dto';

@Component({
  selector: 'app-tasks-tree',
  templateUrl: './tasks-tree.component.html',
  styleUrls: ['./tasks-tree.component.scss'],
})
export class TasksTreeComponent {

  @Input()
  task?: TaskDto;
}
