import {
  AfterViewInit,
  Component,
  ElementRef,
  Inject,
  OnDestroy,
  OnInit,
  QueryList,
  ViewChild,
  ViewChildren
} from '@angular/core';
import { NoteService } from '@app/core/services';
import { ProfileService } from '@app/core/services/profile/profile.service';
import { CdkDragMove } from '@angular/cdk/drag-drop';
import { NoteCardComponent } from './note-card/note-card.component';
import { NoteDto } from '@app/core/dto';
import { DOCUMENT } from '@angular/common';
import { Subject, takeUntil } from 'rxjs';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, AfterViewInit, OnDestroy {

  @ViewChildren(NoteCardComponent)
  noteCards = new QueryList<NoteCardComponent>();

  @ViewChild('dropZone')
  dropZone!: ElementRef<HTMLElement>;

  profile$ = this.profileService.get();
  notes: NoteDto[] = [];
  notesMap = new Map<number, NoteCardComponent>();

  isDraggedToDropZone = false;

  private destroy$ = new Subject();

  constructor(
    private noteService: NoteService,
    private profileService: ProfileService,
    @Inject(DOCUMENT) private doc: Document
  ) {}

  ngOnInit(): void {
    this.noteService.getAll()
      .subscribe(notes => this.notes = notes);
  }

  ngAfterViewInit() {
    this.noteCards.changes
      .pipe(takeUntil(this.destroy$))
      .subscribe(cards => this.pullNoteCardMap(cards));
  }

  ngOnDestroy() {
    this.destroy$.next(null);
    this.destroy$.complete();
  }

  private pullNoteCardMap(cards: QueryList<NoteCardComponent>) {
    cards.forEach(c => this.notesMap.set(c.note!.id, c));
  }

  onNoteMoved($event: CdkDragMove) {
    const point = $event.pointerPosition;
    const elements = this.doc.elementsFromPoint(point.x, point.y);
    const isDropZone = elements.some(el => this.dropZone.nativeElement === el);

    if (this.isDraggedToDropZone !== isDropZone) {
      this.isDraggedToDropZone = isDropZone;
    }
  }

  onNoteDropped(noteId: number) {
    if (this.isDraggedToDropZone) {
      this.isDraggedToDropZone = false;
      this.notes = this.notes.filter(n => n.id !== noteId);
      return;
    }

    this.isDraggedToDropZone = false;
  }
}
