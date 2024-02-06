# Context Propagation in Reactive Programming with Project Reactor

This repository demonstrates the implementation of context propagation in a reactive programming model using Project Reactor in Java. It provides a clear example of how to manage and utilize context across asynchronous streams for effective debugging, logging, and metadata management.

## Overview

In reactive programming, especially with Project Reactor, managing execution context across asynchronous boundaries can be challenging. This project showcases how to leverage Reactor's context features to propagate context information, such as request IDs or user-specific data, through a reactive stream.

### Features

- **Context Propagation**: Demonstrates how to add and manipulate context in a reactive stream.
- **Logging with MDC**: Utilizes Mapped Diagnostic Context (MDC) for enriched logging capabilities.
- **Error Handling**: Shows how to handle errors while maintaining context information.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 17 or newer
- Maven

### Installing

1. Clone the repository:
   ```shell
   https://github.com/chintanpuggalok/context-propagation-project-reactor
   ```
2. Navigate to the project directory:
   ```shell
   cd context-propagation-reactor-example
   ```
3. Build the project:
    - With Maven:
      ```shell
      mvn clean install
      ```

## Usage

This section explains how to use the context propagation features in your reactive streams. The main components are:

- **DemoClass**: Your reactive stream's data carrier.
- **LogUtil**: A utility for adding context information to the logging framework's MDC.

### Code Snippet

```java
Mono<DemoClass> demoClassMono = Mono.just(demoObject)
    .doOnEach(signal -> logUtil.addToMdc(signal.getContextView()))
    .transform(demoClassMono1 -> {
        log.info("inside main post init {}", demoClassMono1.toString());
        return another.anotherDemoProcess(demoClassMono1);
    })
    .contextWrite(context -> context.putAllMap(headerDetails));
```

## Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Acknowledgments

- Project Reactor Team for providing an excellent reactive programming framework.
- All contributors who participate in this project.

```
