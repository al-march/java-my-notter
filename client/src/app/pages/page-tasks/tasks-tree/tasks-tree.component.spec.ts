import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TasksTreeComponent } from './tasks-tree.component';

describe('TasksTreeComponent', () => {
  let component: TasksTreeComponent;
  let fixture: ComponentFixture<TasksTreeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TasksTreeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TasksTreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
