#!/bin/sh
# =============================================================================
# Ollama Manager Script
# Optionally loads a default model on startup
# =============================================================================

set -e

echo "=== Ollama Manager Started ==="

# Get model from environment variable (default to empty if not set)
MODEL="${OLLAMA_DEFAULT_MODEL:-}"

# Install required tools
apk add --no-cache curl jq > /dev/null 2>&1

# Load default model if specified
if [ -n "$MODEL" ]; then
    echo "Loading model: $MODEL"
    
    # Pull model with progress output
    curl -s http://ollama:11434/api/pull \
        -d "{\"name\": \"$MODEL\", \"stream\": true}" | while read -r line; do
        status=$(echo "$line" | jq -r '.status // .message // empty')
        if [ -n "$status" ]; then
            echo "  $status"
        fi
    done
    
    echo "Model '$MODEL' loaded successfully!"
else
    echo "No default model specified (OLLAMA_DEFAULT_MODEL is empty)"
fi

# Show available models
echo ""
echo "Available models:"
curl -s http://ollama:11434/api/tags | jq -r '.models[]?.name // "none"'

echo ""
echo "=== Ollama Manager ready ==="
echo "Use 'docker exec -it n8n-ollama-manager sh' for manual commands"

# Keep container running
tail -f /dev/null