import { CheckCircle2, Circle, ListTodo } from "lucide-react";

interface StatsCardProps {
  label: string;
  value: number;
  icon: "total" | "active" | "completed";
  color: string;
}

export function StatsCard({ label, value, icon, color }: StatsCardProps) {
  const icons = {
    total: ListTodo,
    active: Circle,
    completed: CheckCircle2,
  };
  
  const Icon = icons[icon];
  
  return (
    <div
      className={`
        flex items-center gap-4 p-5 rounded-3xl border border-border
        transition-all duration-300 hover:shadow-md hover:-translate-y-0.5
        ${color}
      `}
    >
      <div className="flex-shrink-0 w-12 h-12 rounded-2xl bg-white/60 flex items-center justify-center">
        <Icon className="w-6 h-6 text-card-foreground" />
      </div>
      <div>
        <div className="text-2xl font-medium text-card-foreground">{value}</div>
        <div className="text-sm text-muted-foreground">{label}</div>
      </div>
    </div>
  );
}
