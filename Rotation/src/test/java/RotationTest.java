import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RotationTest {

    private final String original = "aquickbrownfox";
    @MethodSource("rotations")
    @ParameterizedTest(name = "isRotated({0}) = {1}")
    void isRotated(String input, Boolean isRotated) {
        assertThat(Rotation.isRotated(original, input)).isEqualTo(isRotated);
    }

    private static Stream<Arguments> rotations() {
        return Stream.of(
                Arguments.of("aquickbrownfox", true),
                Arguments.of("brownfoxaquick", true),
                Arguments.of("", false),
                Arguments.of("  ", false),
                Arguments.of(null, false),
                Arguments.of("anotherword", false)
        );
    }
}
