package Enum;

import Task.*;

public enum TaskPeriodicity {
    ONETIME {
        @Override
        public Task createTask() {
            return new OneTimeTask();
        }
    },
    DAILY {
        @Override
        public Task createTask() {
            return new DailyTask();
        }
    },
    WEEKLY {
        @Override
        public Task createTask() {
            return new WeeklyTask();
        }
    },
    MONTHLY {
        @Override
        public Task createTask() {
            return new MonthlyTask();
        }
    },
    YEARLY {
        @Override
        public Task createTask() {
            return new YearlyTask();
        }
    };

    public abstract Task createTask();
}

