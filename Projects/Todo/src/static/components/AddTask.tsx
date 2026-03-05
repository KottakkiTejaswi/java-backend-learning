import { Plus } from "lucide-react";
import { useState } from "react";

interface AddTaskProps {
  onAdd: (text: string) => void;
}

export function AddTask({ onAdd }: AddTaskProps) {
  const [text, setText] = useState("");
  const [isFocused, setIsFocused] = useState(false);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    if (text.trim()) {
      onAdd(text.trim());
      setText("");
    }
  };

  return (
    <form onSubmit={handleSubmit} className="relative">
      <div
        className={`
          flex items-center gap-3 p-4 bg-card rounded-3xl border-2
          transition-all duration-300
          ${
            isFocused
              ? 'border-primary shadow-lg'
              : 'border-border hover:border-primary/40'
          }
        `}
      >
        <div className="flex-shrink-0 w-6 h-6 rounded-full bg-primary/20 flex items-center justify-center">
          <Plus className="w-4 h-4 text-primary" />
        </div>
        
        <input
          type="text"
          value={text}
          onChange={(e) => setText(e.target.value)}
          onFocus={() => setIsFocused(true)}
          onBlur={() => setIsFocused(false)}
          placeholder="Add a new task..."
          className="
            flex-1 bg-transparent outline-none
            placeholder:text-muted-foreground text-card-foreground
          "
        />
        
        <button
          type="submit"
          disabled={!text.trim()}
          className={`
            px-6 py-2 rounded-full transition-all duration-200
            ${
              text.trim()
                ? 'bg-primary text-primary-foreground hover:shadow-md hover:scale-105'
                : 'bg-muted text-muted-foreground cursor-not-allowed'
            }
          `}
        >
          Add
        </button>
      </div>
    </form>
  );
}
