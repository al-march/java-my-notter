import { ChangeDetectionStrategy, Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { NoteDto } from '@app/core/dto';


@Component({
  selector: 'app-note-card',
  standalone: true,
  imports: [CommonModule, DragDropModule],
  templateUrl: './note-card.component.html',
  styleUrls: ['./note-card.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class NoteCardComponent implements OnInit {

  @ViewChild('noteRef')
  noteRef?: ElementRef<HTMLElement>;

  @Input()
  note?: NoteDto;

  constructor() { }

  ngOnInit(): void {
  }
}
