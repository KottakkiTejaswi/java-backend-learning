import { Check, Circle, Trash2 } from "lucide-react";

interface Task {
  id: string;
  text: string;
  completed: boolean;
}

interface TaskCardProps {
  task: Task;
  onToggle: (id: string) => void;
  onDelete: (id: string) => void;
}

export function TaskCard({ task, onToggle, onDelete }: TaskCardProps) {
  return (
    <div
      className={`
        group flex items-center gap-3 p-4 bg-card rounded-3xl border border-border
        transition-all duration-300 hover:shadow-lg hover:-translate-y-0.5
        ${task.completed ? 'opacity-60' : ''}
      `}
    >
      <button
        onClick={() => onToggle(task.id)}
        className={`
          flex-shrink-0 w-6 h-6 rounded-full border-2 flex items-center justify-center
          transition-all duration-200
          ${
            task.completed
              ? 'bg-primary border-primary'
              : 'border-primary/40 hover:border-primary hover:bg-primary/10'
          }
        `}
      >
        {task.completed && <Check className="w-4 h-4 text-primary-foreground" />}
        {!task.completed && <Circle className="w-3 h-3 text-transparent" />}
      </button>
      
      <span
        className={`
          flex-1 transition-all duration-200
          ${task.completed ? 'line-through text-muted-foreground' : 'text-card-foreground'}
        `}
      >
        {task.text}
      </span>
      
      <button
        onClick={() => onDelete(task.id)}
        className="
          flex-shrink-0 w-8 h-8 rounded-full bg-destructive/0 hover:bg-destructive/20
          flex items-center justify-center opacity-0 group-hover:opacity-100
          transition-all duration-200
        "
      >
        <Trash2 className="w-4 h-4 text-destructive" />
      </button>
    </div>
  );
}
