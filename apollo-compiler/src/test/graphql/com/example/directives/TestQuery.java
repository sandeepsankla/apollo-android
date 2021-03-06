package com.example.directives;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.Optional;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public final class TestQuery implements Query<TestQuery.Data, Optional<TestQuery.Data>, TestQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query TestQuery($includeName: Boolean!, $skipFriends: Boolean!) {\n"
      + "  hero {\n"
      + "    __typename\n"
      + "    name @include(if: $includeName)\n"
      + "    friendsConnection @skip(if: $skipFriends) {\n"
      + "      __typename\n"
      + "      totalCount\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "TestQuery";
    }
  };

  private final TestQuery.Variables variables;

  public TestQuery(boolean includeName, boolean skipFriends) {
    variables = new TestQuery.Variables(includeName, skipFriends);
  }

  @Override
  public String operationId() {
    return "330f0fe4baea1b2e41c551ea45b413502c32080fc6581ed3756890896a897ae9";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public Optional<TestQuery.Data> wrapData(TestQuery.Data data) {
    return Optional.fromNullable(data);
  }

  @Override
  public TestQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<TestQuery.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    private boolean includeName;

    private boolean skipFriends;

    Builder() {
    }

    public Builder includeName(boolean includeName) {
      this.includeName = includeName;
      return this;
    }

    public Builder skipFriends(boolean skipFriends) {
      this.skipFriends = skipFriends;
      return this;
    }

    public TestQuery build() {
      return new TestQuery(includeName, skipFriends);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final boolean includeName;

    private final boolean skipFriends;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(boolean includeName, boolean skipFriends) {
      this.includeName = includeName;
      this.skipFriends = skipFriends;
      this.valueMap.put("includeName", includeName);
      this.valueMap.put("skipFriends", skipFriends);
    }

    public boolean includeName() {
      return includeName;
    }

    public boolean skipFriends() {
      return skipFriends;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeBoolean("includeName", includeName);
          writer.writeBoolean("skipFriends", skipFriends);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("hero", "hero", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final Optional<Hero> hero;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable Hero hero) {
      this.hero = Optional.fromNullable(hero);
    }

    public Optional<Hero> hero() {
      return this.hero;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], hero.isPresent() ? hero.get().marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "hero=" + hero
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return this.hero.equals(that.hero);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= hero.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final Hero.Mapper heroFieldMapper = new Hero.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final Hero hero = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<Hero>() {
          @Override
          public Hero read(ResponseReader reader) {
            return heroFieldMapper.map(reader);
          }
        });
        return new Data(hero);
      }
    }
  }

  public static class Hero {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("name", "name", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("includeName", false))),
      ResponseField.forObject("friendsConnection", "friendsConnection", null, true, Arrays.<ResponseField.Condition>asList(ResponseField.Condition.booleanCondition("skipFriends", true)))
    };

    final @Nonnull String __typename;

    final Optional<String> name;

    final Optional<FriendsConnection> friendsConnection;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Hero(@Nonnull String __typename, @Nullable String name,
        @Nullable FriendsConnection friendsConnection) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.name = Optional.fromNullable(name);
      this.friendsConnection = Optional.fromNullable(friendsConnection);
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     * The name of the character
     */
    public Optional<String> name() {
      return this.name;
    }

    /**
     * The friends of the character exposed as a connection with edges
     */
    public Optional<FriendsConnection> friendsConnection() {
      return this.friendsConnection;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], name.isPresent() ? name.get() : null);
          writer.writeObject($responseFields[2], friendsConnection.isPresent() ? friendsConnection.get().marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Hero{"
          + "__typename=" + __typename + ", "
          + "name=" + name + ", "
          + "friendsConnection=" + friendsConnection
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Hero) {
        Hero that = (Hero) o;
        return this.__typename.equals(that.__typename)
         && this.name.equals(that.name)
         && this.friendsConnection.equals(that.friendsConnection);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= name.hashCode();
        h *= 1000003;
        h ^= friendsConnection.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Hero> {
      final FriendsConnection.Mapper friendsConnectionFieldMapper = new FriendsConnection.Mapper();

      @Override
      public Hero map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String name = reader.readString($responseFields[1]);
        final FriendsConnection friendsConnection = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<FriendsConnection>() {
          @Override
          public FriendsConnection read(ResponseReader reader) {
            return friendsConnectionFieldMapper.map(reader);
          }
        });
        return new Hero(__typename, name, friendsConnection);
      }
    }
  }

  public static class FriendsConnection {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forLong("totalCount", "totalCount", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final Optional<Long> totalCount;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public FriendsConnection(@Nonnull String __typename, @Nullable Long totalCount) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.totalCount = Optional.fromNullable(totalCount);
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    /**
     * The total number of friends
     */
    public Optional<Long> totalCount() {
      return this.totalCount;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeLong($responseFields[1], totalCount.isPresent() ? totalCount.get() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FriendsConnection{"
          + "__typename=" + __typename + ", "
          + "totalCount=" + totalCount
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FriendsConnection) {
        FriendsConnection that = (FriendsConnection) o;
        return this.__typename.equals(that.__typename)
         && this.totalCount.equals(that.totalCount);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= totalCount.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<FriendsConnection> {
      @Override
      public FriendsConnection map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Long totalCount = reader.readLong($responseFields[1]);
        return new FriendsConnection(__typename, totalCount);
      }
    }
  }
}
