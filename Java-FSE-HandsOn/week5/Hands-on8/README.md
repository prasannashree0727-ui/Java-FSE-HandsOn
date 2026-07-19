# Student Course Portal — Hands-On 8 Complete

## Setup
npm install
npm install -g json-server   (one-time, per PDF setup note)
json-server --watch db.json --port 3000   (run in a separate terminal)
ng serve
Open http://localhost:4200

`db.json` (project root) is the mock REST backend consumed by CourseService and
EnrollmentService — it seeds `courses` and `students` collections.

## Hands-On 7 recap (preserved, unchanged in behaviour)
- Nested routes, route params, query params, lazy-loaded /enroll, auth guard,
  CanDeactivate guard — see previous README section / app.routes.ts.

## Hands-On 8 checklist

### Task 1 — Replace Service Data with HttpClient Calls
- Step 78: `provideHttpClient(...)` registered in `app.config.ts`; `CourseService`
  injects `HttpClient`.
- Step 79: `getCourses()` / `getCourseById()` now return `Observable<Course[]>` /
  `Observable<Course>` via `HttpClient.get`.
- Step 80: `CourseListComponent.ngOnInit()` subscribes with `next/error/complete`.
- Step 81: `createCourse()` (POST) added to `CourseService`, wired into
  `EnrollmentFormComponent.onSubmit()`.
- Step 82: `updateCourse()` (PUT) and `deleteCourse()` (DELETE) added to
  `CourseService`.

### Task 2 — RxJS Operators and Error Handling
- Step 83: `map` filters out zero/negative-credit courses in `getCourses()`.
- Step 84: `catchError` on every `CourseService`/`EnrollmentService` HTTP call,
  surfaced as `errorMessage` in `CourseListComponent`, `HomeComponent`,
  `CourseDetailComponent`, `StudentProfileComponent`.
- Step 85: `tap` logs the loaded course count before `catchError`.
- Step 86: `retry(2)` on `getCourses()`.
- Step 87: `switchMap` in `CourseDetailComponent` — selecting a course chains into
  `EnrollmentService.getStudentsByCourse(courseId)`; a new courseId cancels the
  previous in-flight student request.

### Task 3 — HTTP Interceptors
- Step 88: `interceptors/auth.interceptor.ts` — adds a mock `Authorization` header
  to every request.
- Step 90: `interceptors/error-handler.interceptor.ts` — global `catchError`:
  401 → navigate home, 500 → console notification, error rethrown.
- Step 91: `interceptors/loading.interceptor.ts` + `services/loading.service.ts`
  (`BehaviorSubject<boolean>`) — global spinner in `app.component.html`, bound via
  the `async` pipe, shown/hidden with `finalize`.
- All three interceptors are registered in `app.config.ts` via
  `provideHttpClient(withInterceptors([...]))`.
