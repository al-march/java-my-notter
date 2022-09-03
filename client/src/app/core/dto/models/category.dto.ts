import { TagDto, NoteDto } from '@app/core/dto';

export interface CategoryDto {
  id: number;
  userId: number;
  title: string;
  description: string;
  tags: TagDto[];
  notes: NoteDto[];
  createdAt: string;
  updatedAt: string;
}

export interface CategoryCreateDto {
  title: string;
  description: string;
  tags?: TagDto[],
}
