#define bool _Bool
#define size_t unsigned

int printf(const char *pattern, ...);
int sprintf(char *dest, const char *pattern, ...);
int scanf(const char *pattern, ...);
int sscanf(const char *src, const char *pattern, ...);
size_t strlen(const char *str);
int strcmp(const char *s1, const char *s2);
void *memcpy(void *dest, const void *src, size_t n);
void *malloc(size_t n);

void print(char *str) {
    printf("%s", str);
}

void println(char *str) {
    printf("%s\n", str);
}

void printInt(int n) {
    printf("%d", n);
}

void printlnInt(int n) {
    printf("%d\n", n);
}

char *getString() {
    char *buffer = malloc(4096);
    scanf("%s", buffer);
    return buffer;
}

int getInt() {
    int n;
    scanf("%d", &n);
    return n;
}

char *toString(int n) {
    char *buffer = malloc(16);
    sprintf(buffer, "%d", n);
    return buffer;
}

size_t __str_length(char *__this) {
    return strlen(__this);
}

char *__str_substring(char *__this, int left, int right) {
    int length = right - left;
    char *buffer = malloc(length + 1);
    memcpy(buffer, __this + left, length);
    buffer[length] = '\0';
    return buffer;
}

int __str_parseInt(char *__this) {
    int n;
    sscanf(__this, "%d", &n);
    return n;
}

int __str_ord(char *__this, int pos) {
    return __this[pos];
}

char *__str_add(char *str1, char *str2) {
    int length1 = strlen(str1);
    int length2 = strlen(str2);
    int length = length1 + length2;
    char *buffer = malloc(length + 1);
    memcpy(buffer, str1, length1);
    memcpy(buffer + length1, str2, length2);
    buffer[length] = '\0';
    return buffer;
}

bool __str_eq(char *str1, char *str2) {
    return strcmp(str1, str2) == 0;
}

bool __str_ne(char *str1, char *str2) {
    return strcmp(str1, str2) != 0;
}

bool __str_lt(char *str1, char *str2) {
    return strcmp(str1, str2) < 0;
}

bool __str_le(char *str1, char *str2) {
    return strcmp(str1, str2) <= 0;
}

bool __str_gt(char *str1, char *str2) {
    return strcmp(str1, str2) > 0;
}

bool __str_ge(char *str1, char *str2) {
    return strcmp(str1, str2) >= 0;
}

int __array_size(void *__this) {
    return ((int*)__this)[-1];
}

void *__new_array(int size, int bit) {
    int *array = malloc((size * bit) + 4);
    array[0] = size;
    return array + 1;
}

void *__new_var(int bit) {
    return malloc(bit);
}