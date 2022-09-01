import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PageTasksRoutingModule } from './page-tasks-routing.module';
import { PageTasksComponent } from './page-tasks.component';
import { TasksTreeComponent } from './tasks-tree/tasks-tree.component';
import { BadgeModule } from '@ng-daisy/data-display';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { TaskComponent } from './tasks-tree/task/task.component';

@NgModule({
  declarations: [
    PageTasksComponent,
    TasksTreeComponent,
    TaskComponent,
  ],
  imports: [
    CommonModule,
    PageTasksRoutingModule,
    BadgeModule,
    DragDropModule
  ]
})
export class PageTasksModule { }
