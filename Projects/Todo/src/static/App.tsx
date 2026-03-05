import { useState } from "react";
import { Sparkles } from "lucide-react";
import { TaskCard } from "./components/TaskCard";
import { AddTask } from "./components/AddTask";
import { StatsCard } from "./components/StatsCard";

interface Task {
  id: string;
  text: string;
  completed: boolean;
}

export default function App() {
  const [tasks, setTasks] = useState<Task[]>([
    { id: "1", text: "Review project proposal", completed: false },
    { id: "2", text: "Buy groceries for the week", completed: true },
    { id: "3", text: "Call mom", completed: false },
  ]);

  const addTask = (text: string) => {
    const newTask: Task = {
      id: Date.now().toString(),
      text,
      completed: false,
    };
    setTasks([newTask, ...tasks]);
  };

  const toggleTask = (id: string) => {
    setTasks(
      tasks.map((task) =>
        task.id === id ? { ...task, completed: !task.completed } : task
      )
    );
  };

  const deleteTask = (id: string) => {
    setTasks(tasks.filter((task) => task.id !== id));
  };

  const totalTasks = tasks.length;
  const completedTasks = tasks.filter((task) => task.completed).length;
  const activeTasks = totalTasks - completedTasks;

  return (
    <div className="min-h-screen w-full bg-background p-6 md:p-10">
      <div className="max-w-4xl mx-auto">
        {/* Header */}
        <div className="mb-8">
          <div className="flex items-center gap-3 mb-2">
            <div className="w-10 h-10 rounded-2xl bg-primary/30 flex items-center justify-center">
              <Sparkles className="w-5 h-5 text-primary" />
            </div>
            <h1 className="text-foreground">My Tasks</h1>
          </div>
          <p className="text-muted-foreground ml-13">
            Keep track of your daily tasks with joy ✨
          </p>
        </div>

        {/* Stats */}
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4 mb-8">
          <StatsCard
            label="Total Tasks"
            value={totalTasks}
            icon="total"
            color="bg-secondary/30"
          />
          <StatsCard
            label="Active"
            value={activeTasks}
            icon="active"
            color="bg-accent/30"
          />
          <StatsCard
            label="Completed"
            value={completedTasks}
            icon="completed"
            color="bg-primary/30"
          />
        </div>

        {/* Add Task */}
        <div className="mb-6">
          <AddTask onAdd={addTask} />
        </div>

        {/* Task List */}
        <div className="space-y-3">
          {tasks.length === 0 ? (
            <div className="text-center py-16">
              <div className="w-20 h-20 rounded-full bg-muted mx-auto mb-4 flex items-center justify-center">
                <Sparkles className="w-10 h-10 text-muted-foreground" />
              </div>
              <p className="text-muted-foreground">
                No tasks yet. Add one to get started! 🎉
              </p>
            </div>
          ) : (
            tasks.map((task) => (
              <TaskCard
                key={task.id}
                task={task}
                onToggle={toggleTask}
                onDelete={deleteTask}
              />
            ))
          )}
        </div>
      </div>
    </div>
  );
}
