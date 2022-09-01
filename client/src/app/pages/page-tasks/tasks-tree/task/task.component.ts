import { Component, Input } from '@angular/core';
import { TaskDto } from '@app/core/dto';
import { ActivatedRoute } from '@angular/router';
import { map } from 'rxjs';


@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent {
  @Input()
  task?: TaskDto;

  isActive$ = this.route.queryParamMap.pipe(
    map(map => map.get('taskId') === String(this.task?.id))
  )

  constructor(
    private route: ActivatedRoute
  ) {}
}
