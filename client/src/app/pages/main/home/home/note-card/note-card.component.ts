import {
  ChangeDetectionStrategy,
  Component,
  ElementRef,
  EventEmitter,
  Input,
  OnInit,
  Output,
  ViewChild
} from '@angular/core';
import { CommonModule } from '@angular/common';
import { CdkDragEnd, CdkDragMove, CdkDragStart, DragDropModule } from '@angular/cdk/drag-drop';
import { NoteDto } from '@app/core/dto';

export class NoteDragState<T> {
  constructor(
    public event: T,
    public component: NoteCardComponent
  ) {}
}

@Component({
  selector: 'app-note-card',
  standalone: true,
  imports: [CommonModule, DragDropModule],
  templateUrl: './note-card.component.html',
  styleUrls: ['./note-card.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class NoteCardComponent implements OnInit {

  @ViewChild('noteRef')
  noteRef?: ElementRef<HTMLElement>;

  @Input()
  note?: NoteDto;

  @Input()
  inDropZone = false;

  @Output()
  dragStarted = new EventEmitter<NoteDragState<CdkDragStart>>();

  @Output()
  dragMoved = new EventEmitter<NoteDragState<CdkDragMove>>();

  @Output()
  dragDropped = new EventEmitter<NoteDragState<CdkDragEnd>>();

  isDragging = false;
  transition = false;
  dragPosition = {x: 0, y: 0};

  constructor() { }

  ngOnInit(): void {
  }

  onDragStarted($event: CdkDragStart) {
    this.isDragging = true;
    const state = new NoteDragState($event, this);
    this.dragStarted.emit(state);
  }

  onDragMoved($event: CdkDragMove) {
    const state = new NoteDragState($event, this);
    this.dragMoved.emit(state);
  }

  onDragDropped($event: CdkDragEnd) {
    const state = new NoteDragState($event, this);
    this.dragDropped.emit(state);

    this.isDragging = false;
    this.transition = true;
    this.dragPosition = {x: 0, y: 0};

    const node = this.noteRef?.nativeElement;
    if (node) {
      node.ontransitioncancel = () => {
        this.transition = false;
      };
    }
  }
}
