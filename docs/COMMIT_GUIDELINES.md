# Commit Message Guidelines

## Introduction
This document provides guidelines for writing meaningful commit messages for the Movies Application project. Good commit messages are important because they:

- Help team members understand the changes without having to look at the code
- Create a more valuable git history for future reference
- Make code reviews more efficient
- Help with generating changelogs and release notes

## Commit Message Structure
A good commit message consists of:

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Type
The type is mandatory and indicates the kind of change:

- **feat**: A new feature
- **fix**: A bug fix
- **docs**: Documentation changes
- **style**: Changes that don't affect code functionality (formatting, etc.)
- **refactor**: Code changes that neither fix bugs nor add features
- **perf**: Performance improvements
- **test**: Adding or correcting tests
- **chore**: Changes to build process, dependencies, etc.

### Scope (Optional)
The scope provides context about what part of the codebase is affected:

- **auth**: Authentication related changes
- **movie**: Movie model or functionality
- **review**: Review model or functionality
- **api**: API endpoints or controllers
- **db**: Database related changes
- **config**: Configuration changes
- **security**: Security related changes
- **docker**: Docker or containerization changes

### Subject
The subject is a short description of the change:

- Use imperative, present tense: "add" not "added" or "adds"
- Don't capitalize the first letter
- No period (.) at the end
- Keep it under 50 characters
- Be specific and concise

### Body (Optional)
The body provides detailed information about the change:

- Separate from subject with a blank line
- Explain the motivation for the change
- Contrast with previous behavior
- Use imperative, present tense
- Wrap lines at 72 characters

### Footer (Optional)
The footer contains information about breaking changes and references to issues:

- Reference issues that this commit closes: "Closes #123, #456"
- Note breaking changes: "BREAKING CHANGE: description of what breaks"

## Examples

### Good Commit Messages

```
feat(movie): add rating field to movie model

Add a rating field to allow users to see the average rating of a movie.
This enhances the user experience by providing more information at a glance.

Closes #123
```

```
fix(auth): resolve token expiration issue

The JWT tokens were not properly checking expiration dates, allowing
expired tokens to be used. This fix adds proper validation.

Closes #456
```

```
refactor(review): improve review submission performance

Optimize the review submission process by reducing database calls
and implementing caching for frequently accessed data.
```

```
docs(api): update API documentation with new endpoints

Update the Swagger documentation to include the newly added
endpoints for user profile management.
```

```
chore(deps): update Spring Boot to version 3.3.1

Update Spring Boot from 3.3.0 to 3.3.1 to address security
vulnerabilities and improve performance.
```

### Bad Commit Messages (Avoid These)

```
fixed stuff
```

```
update code
```

```
WIP
```

```
Added new feature for the thing
```

## Practical Tips

1. **Write the message before committing**: This helps you think about what you're actually committing.
2. **Keep changes focused**: Each commit should represent a single logical change.
3. **Use the imperative mood**: Write as if you're giving a command.
4. **Be specific**: Avoid vague descriptions.
5. **Reference issues**: Always reference related issues when applicable.
6. **Consider the audience**: Write for someone who might read the commit message months later.

## Git Commands for Better Commits

### Amending the Last Commit
If you need to change your last commit message:
```
git commit --amend
```

### Creating Partial Commits
To commit only some of your changes:
```
git add -p
```

### Viewing Commit History
To see a nicely formatted commit history:
```
git log --oneline --graph --decorate
```

## Conclusion
Following these guidelines will help maintain a clean and useful git history. Remember that commit messages are communication tools for your team, including your future self.