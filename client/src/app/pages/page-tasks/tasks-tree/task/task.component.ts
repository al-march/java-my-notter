import { Component, Input } from '@angular/core';
import { TaskDto } from '@app/core/dto';


@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent {
  @Input()
  task?: TaskDto;
}
